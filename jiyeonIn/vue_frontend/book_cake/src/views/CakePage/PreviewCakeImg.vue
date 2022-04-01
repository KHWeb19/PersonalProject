<template>
    <div class="Main">
        <main-page-form></main-page-form>

        <div class="cakeImg">
            <div v-if="$store.state.authInfo !== '관리자'">
                <preview-cake-form></preview-cake-form>
            </div>

            <div v-if="$store.state.authInfo === '관리자'">
                <h4>케이크 보기</h4><br>
                <v-container>
                    <v-row justify="center">
                        <v-col class="d-flex" cols="12" sm="3">
                            <v-select class="selectCake" v-model="storeData.design" :items="selectCake" label="디자인 선택">
                            </v-select>
                        </v-col>
                        <v-col class="d-flex" cols="12" sm="3">
                            <v-select class="selectSize" v-model="storeData.size" :items="selectSize" label="사이즈 선택">
                            </v-select>
                        </v-col>
                        <v-col class="d-flex" cols="12" sm="3">
                            <v-text-field label="가격 작성" v-model="storeData.price"></v-text-field>
                        </v-col>
                    </v-row>
                    <v-row justify="center">
                        <v-col class="d-flex" cols="12" sm="5">
                            <v-file-input type="file" id="files" label="파일 선택" ref="files" v-on:change="handleFileUpload()"></v-file-input>
                        </v-col>
                    </v-row>
                    <v-row justify="center">
                        <v-col class="d-flex" cols="12" sm="2">
                            <v-btn color="black" text @click="onSubmit"><v-icon>mdi-check</v-icon>올리기!</v-btn>
                        </v-col>
                    </v-row>
                </v-container>
            </div>
           
        </div>
        
        <footer-form></footer-form>
    </div>
</template>

<script>
import PreviewCakeForm from '@/components/mainPage/PreviewCakeForm.vue'
import MainPageForm from '@/components/layout/MainPageForm.vue'
import FooterForm from '@/components/layout/FooterForm.vue'
import axios from 'axios'

    export default {
        name: 'PreviewCakeImg',
        data () {
            return {
                storeData: {
                    design: '',
                    size: '',
                    price:''
                }
                ,
                selectCake : ['birthday', 'lover','family','friend','special'],
                selectSize : ['도시락 케이크','1호','2호','3호']
            }
        },
        components: {
            PreviewCakeForm,
            MainPageForm,
            FooterForm,
        },
        methods: {
            handleFileUpload () {
            this.files = this.$refs.files.files
            },
            onSubmit () {
                submitDetail(),
                submitFiles()
            },    
            submitDetail() {
                let vm = this
                axios.post('http://localhost:7777/upload/register',vm.storeData)
                    .then(() => {
                        alert('케이크 정보 등록 완료!')
                        this.$router.go()
                    })
                    .catch(() =>{
                        alert('문제발생')
                    })
            },
            submitFiles () {
                 let formData = new FormData()

                formData.append('fileList', this.files[0])
                

                axios.post(`http://localhost:7777/upload/uploadImg/${design}`, {formData, design:this.storeData.design}, {
                    headers: {
                        'Content-Type': 'multipart/form-data'
                    }
                })
                .then (res => {
                    alert('처리 결과: ' + res.data)
                })
                .catch (res => {
                    alert('처리 결과: ' + res.message)
                })
            }
        }
    }
</script>

<style scoped>

.Main {
    background: rgb(255, 186, 186);
}
.MainLogo {
    display: block; margin: 0px auto;
}

.cakeImg {
    margin:2% 10% 3% 10%;
    padding: 15px;
    border: 3px solid rgb(243, 180, 180);
}

a {
    text-decoration: none;
    font: 300;
}

p {
    color: rgb(0, 0, 0);
    font-weight: 600;
}
hr{ 
    background: #e69191;
    height: 3px;
}
</style>
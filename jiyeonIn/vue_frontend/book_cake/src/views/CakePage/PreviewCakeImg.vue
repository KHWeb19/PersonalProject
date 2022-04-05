<template>
    <div class="Main">

        <div>
            <main-page-form></main-page-form>
        </div>

        <div class="cakeImg">
            <div v-if="($store.state.authInfo !== '관리자') || (this.$store.state.userInfo == null)">
                <h4>케이크 보기</h4><br>
            </div>
            
            

            <div v-if="$store.state.authInfo === '관리자'">
                <h4>케이크 보기</h4><br>
                <v-container>
                    <v-row justify="center">
                        <v-col class="d-flex" cols="12" sm="3">
                            <v-select class="selectCake" v-model="design" :items="selectCake" label="디자인 선택">
                            </v-select>
                        </v-col>
                        <v-col class="d-flex" cols="12" sm="3">
                            <v-select class="selectSize" v-model="size" :items="selectSize" label="사이즈 선택">
                            </v-select>
                        </v-col>
                        <v-col class="d-flex" cols="12" sm="3">
                            <v-text-field label="가격 작성" v-model="price"></v-text-field>
                        </v-col>
                        
                    </v-row>
                    <v-row justify="center">
                        <v-col class="d-flex" cols="12" sm="5">
                            <input type="file" id="storeData.files" ref="files" 
                            multiple v-on:change="handleFileUpload()"/>
                        </v-col>
                    </v-row>
                    <v-row justify="center">
                        <v-col class="d-flex" cols="12" sm="2">
                            <v-btn color="black" text @click="onSubmit()"><v-icon>mdi-check</v-icon>올리기!</v-btn>
                        </v-col>
                    </v-row>
                </v-container>
            </div>

            <swiper-page></swiper-page><br><br><br>

        </div>
        

        <div>
            <footer-form></footer-form>
        </div>

    </div>
    
</template>

<script>
import MainPageForm from '@/components/layout/MainPageForm.vue'
import FooterForm from '@/components/layout/FooterForm.vue'
import axios from 'axios'
import SwiperPage from '@/components/mainPage/SwiperPage.vue'

    export default {
        name: 'PreviewCakeImg',
        data () {
            return {
                files: '',
                response: '',
                design: '',
                size: '',
                price:'',  
                
                selectCake : ['birthday', 'lover','family','friend'],
                selectSize : ['도시락 케이크','1호','2호','3호']
                
                }
            },
        
        components: {
            MainPageForm,
            FooterForm,
            SwiperPage
        },
        methods: {
            handleFileUpload () {
            this.files = this.$refs.files.files
            },
            onSubmit () {
                let formData = new FormData()

                for (let idx = 0; idx < this.files.length; idx++) {
                    formData.append('fileList', this.files[idx])
                 }

                let why = {design : this.design, size: this.size, price: this.price }

                axios.post('http://localhost:7777/upload/register',{ why, formData },{
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
                },
                    
            /*
            submitFiles () {
                let formData = new FormData()

                for (let idx = 0; idx < this.files.length; idx++) {
                    formData.append('fileList', this.files[idx])
                 }

                let dm =this.storeData.design

                if(dm === 'family'){
                    axios.post('http://localhost:7777/upload/uploadImgFamily', {formData, dm }, {
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
                }else if(dm === 'birthday'){
                    axios.post('http://localhost:7777/upload/uploadImgBirthday', formData , {
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
                }else if(dm === 'friend'){
                    axios.post('http://localhost:7777/upload/uploadImgFriend', formData , {
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
                }else if(dm === 'lover'){
                    axios.post('http://localhost:7777/upload/uploadImgLover', formData , {
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
            }*/
            
        }
    }
</script>

<style lang="scss" scoped>

.Main {
    background: rgb(255, 186, 186);
    color: rgb(0, 0, 0);
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
<template>
    <div class="Main">

        <div>
            <main-page-form></main-page-form>
        </div>

        <div class="cakeImg">
            
            <div v-if="(dbrAction != 'manager') || (checkuserInfo == null)">
                <h4>케이크 보기</h4><br>
            </div>

            <div v-show="(dbrAction == 'manager') && (checkuserInfo != null)">
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
                            <input type="file" id="files1" ref="files1" 
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

            <swiper-page :cakeLists="cakeLists"></swiper-page><br><br><br>

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
import { mapState, mapActions} from 'vuex'

    export default {
        name: 'PreviewCakeImg',
        data () {
            return {
                files1: '',
                response: '',
                design: '',
                size: '',
                price:'',  
                selectCake : ['birthday', 'family','friend' , 'lover'],
                selectSize : ['도시락 케이크','1호','2호','3호'],
                dbrAction: (window.localStorage.getItem('id')),
                checkuserInfo: window.localStorage.getItem('token')

                }
            },
        
        components: {
            MainPageForm,
            FooterForm,
            SwiperPage
        },
        computed: {
            ...mapState(['cakeLists'])
        },
        mounted () {
            this.fetchCakeLists()
        },
        methods: {
            ...mapActions(['fetchCakeLists']),
            handleFileUpload () {
            this.files1 = this.$refs.files1.files
            },
            onSubmit () {
                let formData = new FormData()

                let fileInfo = {
                    design : this.design,
                    size : this.size,
                    price : this.price,
                }
                console.log(fileInfo)

                for (let idx = 0; idx < this.files1.length; idx++) {
                    formData.append('fileList', this.files1[idx])
                 }

                formData.append(
                    "info", new Blob([JSON.stringify(fileInfo)], {type: "application/json"})
                );

                axios.post('http://localhost:7777/upload/register', formData) 
                    .then (res => {
                        alert('처리 결과: ' + res.data)
                    })
                    .catch (() => {
                        alert('파일을 추가해주세요!')
                        
                    })
            }
                    
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
<template>
    <div class="Main">
        <main-page-form></main-page-form>

        <div class="cakeImg">
            <div v-if="($store.state.authInfo !== '관리자') || (this.$store.state.userInfo == null)">
                <h4>케이크 보기</h4><br>
                
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
                            <v-col class="d-flex" cols="12" sm="2">
                        <v-btn color="black" text @click="onSubmit"><v-icon>mdi-check</v-icon></v-btn>
                        </v-col>
                    </v-row>
                    <v-row justify="center">
                        <v-col class="d-flex" cols="12" sm="5">
                            <input type="file" id="files" ref="files" 
                            multiple v-on:change="handleFileUpload()"/>
                        </v-col>
                    </v-row>
                    <v-row justify="center">
                        <v-col class="d-flex" cols="12" sm="2">
                            <v-btn color="black" text @click="submitFiles()"><v-icon>mdi-check</v-icon>올리기!</v-btn>
                        </v-col>
                    </v-row>
                </v-container>
            </div>

            <div class="slide-3d" >
            <v-app id="inspire">
            
            
            <br><h3>Birthday</h3>
            <swiper class="swiper" :options="swiperOption">
                <swiper-slide> <img src = "@/assets/uploadImg/birthday/1.famaily cake.png"/></swiper-slide>
                <swiper-slide><img src = "@/assets/uploadImg/birthday/1.famaily cake.png"/></swiper-slide>
                <swiper-slide><img src = "@/assets/uploadImg/birthday/1.famaily cake.png"/></swiper-slide>
                <swiper-slide><img src = "@/assets/uploadImg/birthday/1.famaily cake.png"/></swiper-slide>
                <div class="swiper-pagination" slot="pagination">
                </div>
            </swiper>

            <br><h3>Family</h3>
    
            <swiper class="swiper" :options="swiperOption">
                <swiper-slide> <img src = "@/assets/uploadImg/birthday/1.famaily cake.png"/></swiper-slide>
                <swiper-slide><img src = "@/assets/uploadImg/birthday/1.famaily cake.png"/></swiper-slide>
                <swiper-slide><img src = "@/assets/uploadImg/birthday/1.famaily cake.png"/></swiper-slide>
                <swiper-slide><img src = "@/assets/uploadImg/birthday/1.famaily cake.png"/></swiper-slide>
                <div class="swiper-pagination" slot="pagination">
                </div>
            </swiper>
            
            </v-app>
            </div>
             
            
        </div>
        
        
        <footer-form></footer-form>
    </div>
    
</template>

<script>
import MainPageForm from '@/components/layout/MainPageForm.vue'
import FooterForm from '@/components/layout/FooterForm.vue'
import axios from 'axios'

import { swiper, swiperSlide } from 'vue-awesome-swiper'
import 'swiper/dist/css/swiper.css'


    export default {
        name: 'PreviewCakeImg',
        data () {
            return {
                files: '',
                response: '',

                swiperOption: {
                loop: false, //무한반복원하면 true, 아니면 false
                effect: 'coverflow',
                grabCursor: true, // 사용자가 잡아서 끌수있게 만들어줌, 근데 false랑 true랑 비슷한것같음..
                centeredSlides: false, //센터에서 슬라이드 할수있게 도와줌
                slidesPerView: 'auto',
                coverflowEffect: {
                    rotation: 50, //뭔차이인지 모르겟음
                    stretch: 50, // 센터랑 사이드의 거리..? 클수록 센터랑 딱 달라붙어있다. 별로 보기엔 좋지 않음
                    depth: 100, // 센터랑 사이드의 굴절도?  솔직히 별로 필요는 없는것같다.
                    // 회전을 많이 먹이고 싶은 경우 높이도록 한다.
                    modifier: 0, //0으로 해야 상품들옆으로 넘기는 것 같은 효화를 준다.
                    slideShadows: false //사이드에 그림자가 있냐없냐 체크 가능. true : 그림자있음 / false:없음 // 솔직히 그림자 촌스러움
                },
                pagination: { // 이 단어 자체가 페이지 숨기기 였던 듯
                    el: '.swiper-pagination',
                    dynamicBullets: true //총 몇개가 있는지 밑에가 true면 center와 사이드 몇개만 보이고, false면 전체 개수가 보인다.
                }
                },


                storeData: {
                    design: '',
                    size: '',
                    price:'',
                },
                selectCake : ['birthday', 'lover','family','friend'],
                selectSize : ['도시락 케이크','1호','2호','3호']
                
                }
            },
        
        components: {
            MainPageForm,
            FooterForm,
             swiper,
            swiperSlide
        },
        methods: {
            handleFileUpload () {
            this.files = this.$refs.files.files
            },
            onSubmit () {
                let vm = this
                axios.post('http://localhost:7777/upload/register',vm.storeData)
                    .then(() => {
                        alert('케이크 정보 등록 완료!')
                        
                    })
                    .catch(() =>{
                        alert('문제발생')
                    })
            },
            submitFiles () {
                let formData = new FormData()

                for (let idx = 0; idx < this.files.length; idx++) {
                    formData.append('fileList', this.files[idx])
                 }

                let dm =this.storeData.design

                if(dm === 'family'){
                    axios.post('http://localhost:7777/upload/uploadImgFamily', formData , {
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
            }
            
        }
    }
</script>

<style lang="scss" scoped>

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

.slide-3d {
    width: 100%;
    height: 400px;
    padding-top: 0px;
    padding-bottom: 0px;
}

.swiper {
    height: 100%;
    width: 100%;
    

    .swiper-slide {
        display: flex;
        align-items: center;
        width: 300px;
        height: 300px;
        text-align: center;
        background-position: center;
        background-size: cover;

        img {
            width: 100%;
            height: 100%;
            object-fit: cover;
        }
    }
}

</style>
<template>
    <v-container style="width: 1000px; margin-top: 95px; font-size: 16px">
        <v-flex>
            <v-card>
                <form @submit.prevent="onSubmit">
                    <table style="width: 100%;" >
                        <tr>
                            <td width="33%" >
                                <v-btn icon>
                                    <router-link style="text-decoration: none;" :to="{name: 'HomeView' }">
                                        <v-icon color="black">
                                            mdi-arrow-left
                                        </v-icon>
                                    </router-link>
                                </v-btn>
                            </td>
                            <td align="center" style="font-weight: bold">
                                새 게시물 만들기 
                            </td>
                            <td align="right">
                                <v-btn text color="primary" type="submit">공유하기</v-btn>
                            </td>
                        </tr>
                    </table>
                    <hr style="border: 0; height: 1px; background: #d8d8d8; "/>
                    <!-- <table style="border-collapse : collapse;"> -->
                    <table>
                        <tr>
                            <td v-if="!priview" rowspan="2" colspan="2" height="650px" width="650px">
                                <label for="files">
                                    <span style="padding-left: 240px">컴퓨터에서 사진 선택</span>
                                </label>
                                <input type="file" id="files" ref="files" multiple v-on:change="handleFileUpload()"/>
                            </td>
                            <td v-else rowspan="2" >
                                <div class="slide-3d">
                                    <v-container style="padding: 0px">
                                        <swiper class="swiper" :options="swiperOption">
                                            <swiper-slide ><v-img  width="650px" height="650px" :src="priview"/></swiper-slide>
                                            <swiper-slide v-if="priview2"><v-img width="650px" height="650px" :src="priview2"/></swiper-slide>
                                            <swiper-slide v-if="priview3"><v-img width="650px" height="650px" :src="priview3"/></swiper-slide>
                                            <div class="swiper-pagination" slot="pagination"></div>
                                            <div class="swiper-button-prev" slot="button-prev"></div>
                                            <div class="swiper-button-next" slot="button-next"></div>
                                        </swiper>
                                    </v-container>
                                </div>
                            </td>
                            
                            <td style="font-weight: bold">
                                <div style="display: flex; margin: 0px 16px; height: 60px">
                                    <div style="padding: 16px 12px 0px 0px">
                                        <div style="border-radius: 70%; overflow: hidden;">
                                            <v-img v-if="imageChange" max-width="28" height="28" :src="require(`@/assets/mImage/${imageChange}`)"/>
                                            <v-img v-else-if="loginInfo.imageName" max-width="28" height="28" :src="require(`@/assets/mImage/${loginInfo.imageName}`)"/>
                                            <v-img v-else max-width="28" height="28"  src="@/assets/profile.jpg"/>
                                        </div>
                                    </div>
                                    <input type="text"  v-model="loginInfo.memberId" disabled/>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <textarea style="padding-left: 16px; outline-style: none;" cols="28" rows="23" placeholder="문구 입력..." v-model="content">
                                </textarea>
                            </td>
                        </tr>
                    </table>
                    
                </form>
            </v-card>
        </v-flex>
    </v-container>

</template>

<script>
import axios from 'axios'
import { Swiper, SwiperSlide } from 'vue-awesome-swiper'
import 'swiper/css/swiper.css'
export default {
    name: 'BoardRegisterForm',
    components: {
        Swiper,
        SwiperSlide
    },
    data() {
        return {
            imageChange: JSON.parse(localStorage.getItem('imageChange')),
            loginInfo: JSON.parse(localStorage.getItem('loginInfo')),
            boardImage: '',
            boardImage2: null,
            boardImage3: null,
            content: '',
            priview: '',
            priview2: null,
            priview3: null,
            swiperOption: {
                effect: 'coverflow',
                grabCursor: true,
                navigation: {
                    nextEl: '.swiper-button-next',
                    prevEl: '.swiper-button-prev',
                },
            }
        }
    },
    methods: {
        handleFileUpload () {
            this.files = this.$refs.files.files
            this.priview = URL.createObjectURL(this.files[0])
            if(this.files[1]) {
                this.priview2 = URL.createObjectURL(this.files[1])
                if(this.files[2]) {
                    this.priview3 = URL.createObjectURL(this.files[3])
            }
            }

        },
        onSubmit() {
            let formData = new FormData()
            for (let idx = 0; idx < this.files.length; idx++) {
                formData.append('fileList', this.files[idx])
            }
            axios.post('http://localhost:7777/member/uploadImg', formData, {
                headers: {
                    'Content-Type': 'multipart/form-data',
                }
            })
            .then (res => {
                alert('처리 결과: ' + res.data)
                this.boardImage = this.files[0].name
                if(this.files[1]) {
                    this.boardImage2 = this.files[1].name
                    if(this.files[2]) {
                        this.boardImage3 = this.files[2].name
                        const { boardImage, boardImage2, boardImage3, content } = this
                        this.$emit('submit', { memberNo: this.loginInfo.memberNo, boardImage, boardImage2, boardImage3, content })
                    } else {
                        const { boardImage, boardImage2, content } = this
                        this.$emit('submit', { memberNo: this.loginInfo.memberNo, boardImage, boardImage2, content })
                    }
                } else { 
                    const { boardImage, content } = this
                    this.$emit('submit', { memberNo: this.loginInfo.memberNo, boardImage, content })
                }
                

            })
            .catch (res => {
                alert('처리 결과: ' + res.message)
            })
            
        }
    }
}
</script>

<style lang="scss" scoped>
label {
    color: blue;
}

/* 못생긴 기존 input 숨기기 */
#files {
    visibility: hidden;
}

.slide-3d {
    width: 650px;
}
.swiper {

    .swiper-slide {
        width: 650px;
        height: 650px;
        background-color: white;
        background-position: center;
        background-size: cover;
    }
    
}
.swiper-button-prev, .swiper-button-next {
  --swiper-theme-color: #ffffff;
}
</style>
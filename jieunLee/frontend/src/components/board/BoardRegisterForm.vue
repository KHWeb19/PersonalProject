<template>
    <v-container style="width: 1000px; margin-top: 95px; font-size: 16px">
        <v-flex>
            <v-card style="height: 100%">
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
                    <table style="border-collapse : collapse;">
                        <tr >
                            <td v-if="!priview" rowspan="2" colspan="2" height="700px" width="700px">
                                <label for="files">
                                    <span style="margin-left: 270px">컴퓨터에서 사진 선택</span>
                                </label>
                                <input type="file" id="files" ref="files" multiple v-on:change="handleFileUpload()"/>
                            </td>
                            <td v-else rowspan="2" colspan="2" width="700px" >
                                <v-img max-height="700px" max-width="700px" :src="priview" />
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
                                <textarea style="padding: 0px 16px; outline-style: none;" cols="30" rows="25" placeholder="문구 입력..." v-model="content">
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
export default {
    name: 'BoardRegisterForm',
    data() {
        return {
            loginInfo: JSON.parse(localStorage.getItem('loginInfo')),
            boardImage: '',
            content: '',
            priview: ''
        }
    },
    methods: {
        handleFileUpload () {
            
            this.files = this.$refs.files.files
            this.priview = URL.createObjectURL(this.files[0])
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
                console.log(this.files[0].name)
                this.boardImage = this.files[0].name
                //
                // console.log(this.loginInfo.memberNo)
                const { boardImage, content } = this
                this.$emit('submit', { memberNo: this.loginInfo.memberNo, boardImage, content })
            })
            .catch (res => {
                alert('처리 결과: ' + res.message)
            })
            
        }
    }
}
</script>

<style scoped>
label {
    color: blue;
}

/* 못생긴 기존 input 숨기기 */
#files {
    visibility: hidden;
}

</style>
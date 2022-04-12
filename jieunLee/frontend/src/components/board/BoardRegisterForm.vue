<template>
    <v-container style="width: 1000px; margin-top: 20px; ">
        <v-flex>
            <v-card style="height: 100%">
                <form @submit.prevent="onSubmit">
                    <table style="width: 100%;" >
                        <tr >
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
                    <table style="width: 100%; border-collapse : collapse;">
                        
                        <tr>
                            <td align="center" rowspan="2" colspan="2" width="66%" >
                                
                                사진 선택
                               
                            </td>
                            <td style="font-weight: bold">
                                <input style="margin: 16px" type="text" v-model="loginInfo.memberId" disabled/>
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
export default {
    name: 'BoardRegisterForm',
    data() {
        return {
            loginInfo: JSON.parse(localStorage.getItem('loginInfo')),
            boardImage: '',
            content: ''
        }
    },
    methods: {
        onSubmit() {
            const { boardImage,  content } = this
            this.$emit('submit', { boardImage, writer: this.loginInfo.memberName, content })
        }
    }
}
</script>

<style>
input textarea { outline-style: none; }
</style>
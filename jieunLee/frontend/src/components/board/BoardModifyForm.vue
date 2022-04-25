<template>
    <v-container style="width: 1000px; margin-top: 95px; ">
        <v-flex>
            <v-card style="height: 100%">
                <form @submit.prevent="onSubmit">
                    <table style="width: 100%;" >
                        <tr >
                            <td width="33%" >
                                <router-link style="text-decoration: none;" :to="{
                                    name: 'HomeView'}">
                                        <v-btn text color="black">취소</v-btn>
                                </router-link>
                            </td>
                            <td align="center" style="font-weight: bold">
                                정보 수정
                            </td>
                            <td align="right">
                                <v-btn text color="primary" type="submit">완료</v-btn>
                            </td>
                        </tr>
                    </table>
                    <hr style="border: 0; height: 1px; background: #d8d8d8; "/>
                    <table style="width: 100%; border-collapse : collapse;">
                        <tr>
                            <td align="center" rowspan="2" colspan="2" width="700px%" >
                                <v-img max-height="700px" width="700px" :src="require(`@/assets/mImage/${board.boardImage}`)"/>
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
                                    <input type="text"  v-model="board.member.memberId" disabled/>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <textarea style="padding: 0px 16px; outline-style: none;" cols="30" rows="25" v-model="content">
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
    name: 'BoardModifyForm',
    props: {
        board: {
            type: Object,
            require: true
        }
    },
    data() {
        return {
            loginInfo: JSON.parse(localStorage.getItem('loginInfo')),
            boardImage: '',
            content: ''
        }
    },
    methods: {
        onSubmit() {
            const {boardImage, content} = this
            this.$emit('submit', {memberNo: this.loginInfo.memberNo, boardImage, content})
        }
    },
    created() {
        this.boardImage = this.board.boardImage
        this.content = this.board.content
    }
}
</script>
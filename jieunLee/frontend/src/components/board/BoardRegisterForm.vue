<template>
    <v-container style="width: 700px; margin-top: 20px; padding-left: 0px">
        <v-flex>
            <v-card style="height: 320px">
                새 게시물 생성
                <form @submit.prevent="onSubmit">
                    <table>
                        <tr>
                            <td>제목</td>
                            <td>
                                <input type="text" v-model="boardImage"/>
                            </td>
                        </tr>
                        <tr>
                            <td>작성자</td>
                            <td>
                                <input type="text" v-model="loginInfo.memberId" disabled/>
                            </td>
                        </tr>
                        <tr>
                            <td>본문</td>
                            <td>
                                <textarea cols="50" rows="20" v-model="content">
                                </textarea>
                            </td>
                        </tr>
                    </table>

                    <div>
                        <button type="submit">등록</button>
                        <router-link :to="{name: 'BoardListPage' }">
                            취소
                        </router-link>
                    </div>
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
            boardImage: '제목을 작성하세요.',
            content: '본문을 작성하세요.'
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
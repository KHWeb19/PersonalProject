<template>
<div align="center">
    <v-container>
    <form @submit.prevent="onSubmit">
        <table>
            <tr>
                <td>제목</td>
                <td>
                    <input type="text" v-model="title" placeholder=" *필수 입력"/>
                </td>
            </tr>
            <tr>
                <td>작성자</td>
                <td>
                    <input type="text" v-model="this.$store.state.userInfo.sn" placeholder=" *필수 입력"/>
                </td>
            </tr>
            <tr>
                <td>비밀번호</td>
                <td>
                    <input type="text" v-model="password" placeholder=" *필수 입력"/>
                </td>
            </tr>
            <tr>
                <td>본문</td>
                <td>
                    <textarea cols="50" rows="20" v-model="content" placeholder=" *내용을 작성해주세요.">
                    </textarea>
                </td>
            </tr>
        </table>

        <div>
            <v-btn type="submit">등록</v-btn>
            <router-link :to="{ name: 'livingTipBoardList' }">
                <v-btn>
                    취소
                </v-btn>
            </router-link>
        </div>
    </form>
    </v-container>
</div>
</template>

<script>
export default {
    name: 'TipRegisterForm.vue',
    data () {
        return {
            title: '',
            writer: '',
            password: '',
            content: '',
        }
    },
    methods: {
        onSubmit () {
            const { title, writer, password, content } = this
            this.$emit('submit', { title, writer, password, content })
        }
    }
    
}
</script>


<style scoped>
tr {
    height: 50px;
}
</style>
<template>
    <form @submit.prevent="onSubmit">
        <table>
            <tr>
                <td>제목</td>
                <td>
                    <input type="text" v-model="title"/>
                </td>
            </tr>
            <tr>
                <td>작성자</td>
                <td>
                    {{ this.writer }} 
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
            <router-link :to="{ name: 'FreeBoardListPage' }">
                취소
            </router-link>
        </div>
    </form>
</template>

<script>

export default {
    name: 'FreeBoardRegisterForm',
    data () {
        return {
            title: '',
            writer: this.$store.state.userInfo.nickname,
            content: ''
        }
    },
    methods: {
        onSubmit () {
            const { title, writer, content } = this
            this.$emit('submit', { title, writer, content })
        }
    }
}
</script>
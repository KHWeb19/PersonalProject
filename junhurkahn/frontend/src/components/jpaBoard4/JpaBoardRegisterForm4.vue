<template>
    <form @submit.prevent="onSubmit">
        <table>
            <tr>
                <td>사이트아이디</td>
                <td>
                    <input type="text" v-model="title"/>
                </td>
            </tr>
            <tr>
                <td>사이트주소</td>
                <td>
                    <input type="text" v-model="writer"/>
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
            <router-link :to="{ name: 'JpaBoardListPage4' }">
                취소
            </router-link>
        </div>
    </form>
</template>

<script>
export default {
    name: 'JpaBoardRegisterForm4',
    data () {
        return {
            title: '아이디를 작성하세요.',
            writer: '주소를 작성',
            content: '본문을 작성하세요.'
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
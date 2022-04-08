<template>
    <form @submit.prevent="onSubmit">
        <table border="1">
            <tr>
                <td>가게이름</td>
                <td>
                    <input type="text" v-model="content"/>
                </td>
            </tr>
            <tr>
                <td>물건목록</td>
                <td>
                    <textarea cols="50" rows="20" v-model="title">
                    </textarea>
                </td>
            </tr>
        </table>

        <div>
            <button type="submit">등록</button>
            <router-link :to="{ name: 'JpaBoardListPage2' }">
                취소
            </router-link>
        </div>
    </form>
</template>

<script>
export default {
    name: 'JpaBoardRegisterForm2',
    data () {
        return {
            title: '물건목록을 작성하세요.',
            content: '본문을 작성하세요.'
        }
    },
    methods: {
        onSubmit () {
            const { title, content } = this
            this.$emit('submit', { title,  content })
        }
    }
}
</script>
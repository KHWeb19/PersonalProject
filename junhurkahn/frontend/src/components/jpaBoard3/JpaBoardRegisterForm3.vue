<template>
    <form @submit.prevent="onSubmit">
       <table border="1">
            <tr>
                <td>이름</td>
                <td>
                    <input type="text" v-model="title"/>
                </td>
            </tr>
            <tr>
                <td>생년월일</td>
                <td>
                    <input type="text" v-model="writer"/>
                </td>
            </tr>

             <tr>
                <td>D-day</td>
                <td>
                    <input type="text" v-model="writer1"/>
                </td>
            </tr>




            <tr>
                <td>메모</td>
                <td>
                    <textarea cols="50" rows="20" v-model="content">
                    </textarea>
                </td>
            </tr>
        </table>

        <div>
            <button type="submit">등록</button>
            <router-link :to="{ name: 'JpaBoardListPage3' }">
                취소
            </router-link>
        </div>
    </form>
</template>

<script>
export default {
    name: 'JpaBoardRegisterForm3',
    data () {
        return {
            title: '이름을 작성하세요.',
            writer: '생년월일을 작성',
            writer1: 'D-day 작성하세요',
            content: '메모를 작성하세요.'
        }
    },
    methods: {
        onSubmit () {
            const { title, writer, writer1, content } = this
            this.$emit('submit', { title, writer, writer1, content })
        }
    }
}
</script>
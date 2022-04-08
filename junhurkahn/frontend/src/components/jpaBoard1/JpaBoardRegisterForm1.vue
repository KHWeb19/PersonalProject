<template>
    <form @submit.prevent="onSubmit">
               <table border="1">
            <tr>
                <td>은행이름</td>
                <td>
                    <input type="text" v-model="title"/>
                </td>
            </tr>
            <tr>
                <td>계좌번호</td>
                <td>
                    <input type="text" v-model="writer"/>
                </td>
            </tr>

             <tr>
                <td>소유자이름</td>
                <td>
                    <input type="text" v-model="writer1"/>
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
            <router-link :to="{ name: 'JpaBoardListPage1' }">
                취소
            </router-link>
        </div>
    </form>
</template>

<script>
export default {
    name: 'JpaBoardRegisterForm1',
    data () {
        return {
            title: '은행이름을 작성하세요.',
            writer: '계좌 번호작성하시오',
            writer1: '소유자 이름을 작성하시오',
            content: '본문을 작성하세요.'
        }
    },
    methods: {
        onSubmit () {
            const { title, writer, content, writer1 } = this
            this.$emit('submit', { title, writer, content, writer1 })
        }
    }
}
</script>
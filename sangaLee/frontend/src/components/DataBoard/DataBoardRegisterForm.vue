<template>
    <form @submit.prevent="onSubmit">

        <table>

            <!-- 제목 -->
            <tr>
                <td>제목</td>
                <td>
                    <input type="text" v-model="title"/>
                </td>
            </tr>

            <!-- 작성자 -->
            <tr>
                <td>작성자</td>
                <td>
                    <input type="text" v-model="writer"/>
                </td>
            </tr>

            <!-- 본문 -->
            <tr>
                <td>본문</td>
                <td>
                    <textarea cols="50" rows="20" v-model="content">
                    </textarea>
                </td>
            </tr>

        </table>


        <!-- 게시글 등록, 취소 버튼 -->
        <div>
            <button type="submit">등록</button>
            <router-link :to="{ name: 'DataBoardListPage' }">
                취소
            </router-link>
        </div>

    </form>
</template>

<script>
export default {
    name: 'DataBoardRegisterForm.vue',
    data () {
        return {
            title: '제목을 작성하세요.',
            writer: '너님',
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
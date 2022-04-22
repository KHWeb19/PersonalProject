<template>
    <div>
        <form @submit.prevent="onSubmit">
            <table border="1">
                <tr>
                    <td>게시물 번호</td>
                    <td>
                        <input type="text" :value="noticeBoard.boardNo" disabled/>
                    </td>
                </tr>
                <tr>
                    <td>제목</td>
                    <td>
                        <input type="text" v-model="title"/>
                    </td>
                </tr>
                <tr>
                    <td>작성자</td>
                    <td>
                        <input type="text" :value="noticeBoard.writer" disabled/>
                    </td>
                </tr>
                <tr>
                    <td>등록일자</td>
                    <td>
                        <input type="text" :value="noticeBoard.regDate.split('T')[0]" disabled/>
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
                <v-btn plain class="basil--text" type="submit">수정 완료</v-btn>
                <v-btn plain class="basil--text" router-link :to="{ name: 'NoticeReadPage',
                                    params: { boardNo: noticeBoard.boardNo.toString() } }">
                    취소
                </v-btn>
            </div>
        </form>
    </div>
</template>

<script>

export default {
    name: 'NoticeModifyForm',
    props: {
        noticeBoard: {
            type: Object,
            required: true
        }
    },
    data () {
        return {
            title: '',
            content: ''
        }
    },
    methods: {
        onSubmit () {
            const { title, content } = this
            this.$emit('submit', { title, content })
        }
    },
    created () {
        this.title = this.noticeBoard.title
        this.content = this.noticeBoard.content
    }
}
</script>
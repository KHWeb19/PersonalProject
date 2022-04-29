<template>
    <div>
        <form @submit.prevent="onSubmit">
                     <b-container fluid>
            <b-row hidden >
                <b-col sm="3"><label>게시물 번호</label></b-col>
                <b-col sm="6">
                    <b-form-input type="text" :value="noticeBoard.boardNo"></b-form-input>
                </b-col>
            </b-row>

            <b-row >
                <b-col sm="3"><label>제목</label></b-col>
                <b-col sm="6">
                    <b-form-input type="text" v-model="title" />
                </b-col>
            </b-row>

            <b-row >
                <b-col sm="3"><label>작성자</label></b-col>
                <b-col sm="6">
                    <b-form-input type="text" :value="noticeBoard.writer" disabled/>
                </b-col>
            </b-row>
            
            <b-row >
                <b-col sm="3"><label>등록일자</label></b-col>
                <b-col sm="6">
                    <b-form-input type="text" :value="noticeBoard.regDate.split('T')[0]" disabled/>
                </b-col>
            </b-row>
            
            <b-row >
                <b-col sm="3"><label>본문</label></b-col>
                <b-col sm="6">
                <b-form-textarea cols="50" rows="20" v-model="content">
                </b-form-textarea>
                </b-col>
            </b-row>
    
        </b-container>
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
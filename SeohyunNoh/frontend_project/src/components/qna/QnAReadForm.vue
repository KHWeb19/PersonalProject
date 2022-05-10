<template>
    <div>
        <b-container fluid>
            <b-row hidden >
                <b-col sm="3"><label>게시물 번호</label></b-col>
                <b-col sm="6">
                    <b-form-input type="text" :value="qnaBoard.qnaNo" readonly></b-form-input>
                </b-col>
            </b-row>

            <b-row >
                <b-col sm="3"><label>제목</label></b-col>
                <b-col sm="6">
                    <b-form-input type="text" :value="qnaBoard.title" readonly/>
                </b-col>
            </b-row>

            <b-row >
                <b-col sm="3"><label>작성자</label></b-col>
                <b-col sm="6">
                    <b-form-input type="text" :value="qnaBoard.writer" readonly/>
                </b-col>
            </b-row>
            
            <b-row >
                <b-col sm="3"><label>등록일자</label></b-col>
                <b-col sm="6">
                    <b-form-input type="text" :value="qnaBoard.regDate.split('T')[0]" readonly/>
                </b-col>
            </b-row>
            
            <b-row >
                <b-col sm="3"><label>본문</label></b-col>
                <b-col sm="6">
                <b-form-textarea cols="50" rows="20" :value="qnaBoard.content" readonly>
                </b-form-textarea>
                </b-col>
            </b-row>
    
        </b-container>
    </div>
</template>

<script>

export default {
    name: 'QnAReadForm',
    props: {
        qnaBoard: {
            type: Object,
            required: true
        }
    }
}
</script>

<style scoped>

</style>
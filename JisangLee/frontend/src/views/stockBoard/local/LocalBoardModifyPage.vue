<template>
    <div align="center">
    <br><br><br>
    <span id="shadow" class="shadow">국내 주식 분석</span>
    <br><br><br>
    <local-board-modify-form v-if="localBoard" :localBoard="localBoard" @submit="onSubmit"/>
    </div> 
</template>

<script>
import swal from 'sweetalert';
import axios from 'axios'
import { mapActions, mapState } from 'vuex'
import LocalBoardModifyForm from '@/components/stockBoard/local/LocalBoardModifyForm.vue'

export default {
    name: 'LocalBoardModifyPage,CommentList',
    components: {
        LocalBoardModifyForm,
    },
    props: {
        boardNo: {
            type: String,
            required: true
        },
    },
    computed: {
        ...mapState(['localBoard'])
    },
    methods: {
        ...mapActions(['fetchLocalBoard']),
        onSubmit (payload) {
            const { title, content, viewCnt } = payload

            axios.put(`http://localhost:7777/localboard/${this.boardNo}`,
                { title, writer: this.localBoard.writer, content, createdDate: this.localBoard.createdDate, viewCnt })
                    .then(res => {
                        swal({                                                                              
                            text: "게시물이 수정되었습니다!",
                            icon: "success"
                            })
                        this.$router.push({
                            name: 'LocalBoardReadPage',
                            params: { boardNo: res.data.boardNo.toString() }
                        })
                    })
                    .catch(() => {
                        alert('게시물 수정 실패!')
                    })
        },
    },
    created () {
        this.fetchLocalBoard(this.boardNo)
                .catch(() => {
                    alert('게시물 DB 조회 실패!')
                    this.$router.back()
                })         
    },
}
</script>
<style scoped>
table {
    position: relative;
    background-color:rgb(40, 44, 53) ;
    font-size: 20px;
    color: white;
    padding-left: 0%;
    padding-right: 0%;
    padding-top:0%;
    padding-bottom:0%;
    margin-left:auto;
    margin-right:auto;
}
.label{
    font-family: 'Cute Font', cursive;
    margin-right:0%;
}
.v-textarea {
    font-family: 'Noto Sans KR', sans-serif;
}
.commentList {
    font-family: 'Cute Font', cursive;
}
</style>

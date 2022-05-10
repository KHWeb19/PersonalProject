<template>
    <div align="center">
    <br><br><br>
    <span id="shadow" class="shadow">해외 주식 분석</span>
    <br><br><br>
    <foreign-board-modify-form v-if="foreignBoard" :foreignBoard="foreignBoard" @submit="onSubmit"/>    
    </div>
</template>

<script>
import swal from 'sweetalert';
import axios from 'axios'
import { mapActions, mapState } from 'vuex'
import ForeignBoardModifyForm from '@/components/stockBoard/foreign/ForeignBoardModifyForm.vue'

export default {
    name: 'ForeignBoardModifyPage',
    components: {
        ForeignBoardModifyForm
    },
    props: {
        boardNo: {
            type: String,
            required: true
        }
    },
    computed: {
        ...mapState(['foreignBoard'])
    },
    methods: {
        ...mapActions(['fetchForeignBoard']),
        onSubmit (payload) {
            const { title, content, viewCnt } = payload

            axios.put(`http://localhost:7777/foreignboard/${this.boardNo}`,
                { title, writer: this.foreignBoard.writer, content, createdDate: this.foreignBoard.createdDate, viewCnt })
                    .then(res => {
                        swal({                                                                              
                            text: "게시물이 수정되었습니다!",
                            icon: "success"
                            })
                        this.$router.push({
                            name: 'ForeignBoardReadPage',
                            params: { boardNo: res.data.boardNo.toString() }
                        })
                    })
                    .catch(() => {
                        alert('게시물 수정 실패!')
                    })
        }
    },
    created () {
        this.fetchForeignBoard(this.boardNo)
                .catch(() => {
                    alert('게시물 DB 조회 실패!')
                    this.$router.back()
                })
    }
}
</script>
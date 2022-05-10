<template>
    <div align="center">
    <br><br><br>
    <span id="shadow" class="shadow">하소연</span>
    <br><br><br>
    <complaint-board-modify-form v-if="complaintBoard" :complaintBoard="complaintBoard" @submit="onSubmit"/>    
    </div>
</template>

<script>
import swal from 'sweetalert';
import axios from 'axios'
import { mapActions, mapState } from 'vuex'
import ComplaintBoardModifyForm from '@/components/stockBoard/complaint/ComplaintBoardModifyForm.vue'

export default {
    name: 'ComplaintBoardModifyPage',
    components: {
        ComplaintBoardModifyForm
    },
    props: {
        boardNo: {
            type: String,
            required: true
        }
    },
    computed: {
        ...mapState(['complaintBoard'])
    },
    methods: {
        ...mapActions(['fetchComplaintBoard']),
        onSubmit (payload) {
            const { title, content, viewCnt } = payload

            axios.put(`http://localhost:7777/complaintboard/${this.boardNo}`,
                { title, writer: this.complaintBoard.writer, content, createdDate: this.complaintBoard.createdDate, viewCnt })
                    .then(res => {
                        swal({                                                                              
                            text: "게시물이 수정되었습니다!",
                            icon: "success"
                            })
                        this.$router.push({
                            name: 'ComplaintBoardReadPage',
                            params: { boardNo: res.data.boardNo.toString() }
                        })
                    })
                    .catch(() => {
                        alert('게시물 수정 실패!')
                    })
        }
    },
    created () {
        this.fetchComplaintBoard(this.boardNo)
                .catch(() => {
                    alert('게시물 DB 조회 실패!')
                    this.$router.back()
                })
    }
}

</script>
<template>
    <div align="center">

        <br/>

        <notice-modify-form v-if="noticeBoard" :noticeBoard="noticeBoard" @submit="onSubmit"/>
        <p v-else>로딩중 .......</p>
    </div>
</template>

<script>

import axios from 'axios'
import { mapActions, mapState } from 'vuex'
import NoticeModifyForm from '@/components/notice/NoticeModifyForm.vue'

export default {
    name: 'NoticeModifyPage',
    components: {
        NoticeModifyForm
    },
    props: {
        boardNo: {
            type: String,
            required: true
        }
    },
    computed: {
        ...mapState(['noticeBoard'])
    },
    methods: {
        ...mapActions(['fetchNoticeBoard']),
        onSubmit (payload) {
            const { title, content } = payload

            axios.put(`http://localhost:7777/notice/${this.boardNo}`,
                { title, writer: this.noticeBoard.writer, content, regDate: this.noticeBoard.regDate })
                    .then(res => {
                        alert('게시물 수정 성공!')
                        this.$router.push({
                            name: 'NoticeReadPage',
                            params: { boardNo: res.data.boardNo.toString() }
                        })
                    })
                    .catch(() => {
                        alert('게시물 수정 실패!')
                    })
        }
    },
    created () {
        this.fetchNoticeBoard(this.boardNo)
                .catch(() => {
                    alert('게시물 DB 조회 실패!')
                    this.$router.back()
                })
    }
}

</script>
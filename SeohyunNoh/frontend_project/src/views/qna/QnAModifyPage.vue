<template>
    <div align="center">

        <br/>

        <qn-a-modify-form v-if="qnaBoard" :qnaBoard="qnaBoard" @submit="onSubmit"/>

        <p v-else>로딩중 .......</p>
    </div>
</template>

<script>

import axios from 'axios'
import { mapActions, mapState } from 'vuex'
import QnAModifyForm from '@/components/qna/QnAModifyForm.vue'

export default {
    name: 'QnAModifyPage',
    components: {
        QnAModifyForm
    },
    props: {
        qnaNo: {
            type: String,
            required: true
        }
    },
    computed: {
        ...mapState(['qnaBoard'])
    },
    methods: {
        ...mapActions(['fetchQnA']),
        onSubmit (payload) {
            const { title, content } = payload

            axios.put(`http://localhost:7777/qna/${this.qnaNo}`,
                { title, writer: this.qnaBoard.writer, content, regDate: this.qnaBoard.regDate })
                    .then(res => {
                        alert('게시물 수정 성공!')
                        this.$router.push({
                            name: 'QnAReadPage',
                            params: { qnaNo: res.data.qnaNo.toString() }
                        })
                    })
                    .catch(() => {
                        alert('게시물 수정 실패!')
                    })
        }
    },
    created () {
        this.fetchQnA(this.qnaNo)
                .catch(() => {
                    alert('게시물 DB 조회 실패!')
                    this.$router.back()
                })
    }
}

</script>
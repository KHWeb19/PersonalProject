<template>
    <div align="center">
        <br>
        <h1>게시글 수정</h1>
        <br>        
        <tip-modify-form v-if="tipBoard" :tipBoard="tipBoard" @submit="onSubmit"/>
        <p v-else><img src="@/assets/loadRing.gif"/></p> <!-- 로딩 gif -->
    </div>
</template>


<script>
import axios from 'axios'
import { mapActions, mapState } from 'vuex'
import TipModifyForm from '@/components/livingTip/TipModifyForm.vue'

export default {
    name: 'TipModifyPage',
    components: {
        TipModifyForm
    },
    props: {
        boardNo: {
            type: String,
            required: true
        }
    },
    computed: {
        ...mapState(['tipBoard'])
    },
    methods: {
        ...mapActions(['fetchTipBoard']),
        onSubmit (payload) {
            const { title, content } = payload
            axios.put(`http://localhost:7777/tipboard/${this.boardNo}`,
                { title, writer: this.tipBoard.writer, password: this.tipBoard.password, content, regDate: this.tipBoard.regDate })
                    .then(res => {
                        alert('게시물 수정 성공!')
                        this.$router.push({
                            name: 'TipReadPage',
                            params: { boardNo: res.data.boardNo.toString() }
                        })
                    })
                    .catch(() => {
                        alert('게시물 수정 실패!')
                    })
        }
    },
    created () {
        this.fetchTipBoard(this.boardNo)
                .catch(() => {
                    alert('게시물 DB 조회 실패!')
                    this.$router.back()
                })
    }
}
</script>

<style scoped>
h1{
  color: #907bb0;
}
</style>
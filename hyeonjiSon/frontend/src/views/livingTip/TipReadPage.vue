<template>
    <div>

        <v-container style="width: 800px;">
                <v-row>
                    <v-btn @click="goList">게시판으로</v-btn>
                </v-row>
        </v-container>

        <tip-read-form v-if="tipBoard" :tipBoard="tipBoard"/>
        <p v-else>로딩중 ....... </p>


        <v-container v-if="this.$store.state.userInfo.sn == tipBoard.writer">
            <v-spacer></v-spacer>
                <v-btn @click="modify(tipBoard.boardNo)">수정</v-btn>
                &ensp;
                <v-btn @click="onDelete">삭제</v-btn>
        </v-container>

    </div>
</template>

<script>
import axios from 'axios'
import { mapActions, mapState } from 'vuex'
import TipReadForm from '@/components/livingTip/TipReadForm.vue'
export default {
    name: 'TipReadPage',
    props: {
        boardNo: {
            type: String,
            required: true
        }
    },
    components: {
        TipReadForm,
    },
    computed: {
        ...mapState(['tipBoard'])
    },
    created () {
        this.fetchTipBoard(this.boardNo)
                .catch(() => {
                    alert('게시물 요청 실패!')
                    this.$router.push()
                })
    },
    methods: {
        ...mapActions(['fetchTipBoard']),
        goList(){
            this.$router.push({ name: 'livingTipBoardList' })
        },
        modify(boardNo){
            this.$router.push({ name: 'TipModifyPage', params: { boardNo } })
        },
        onDelete () {
            const { boardNo } = this.tipBoard
            //alert('지우는 게시물 번호: ' + boardNo)
            axios.delete(`http://localhost:7777/tipboard/${boardNo}`)
                    .then(() => {
                        alert('삭제 성공!')
                        this.$router.push({ name: 'livingTipBoardList' })
                    })
                    .catch(() => {
                        alert('삭제 실패! 문제 발생!')
                    })
        }        
    }
}
</script>
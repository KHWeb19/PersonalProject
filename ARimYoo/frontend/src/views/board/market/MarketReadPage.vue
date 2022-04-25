<template>
    <v-container>
        <v-row justify="center">
            <img class="titleImg" src="@/assets/title/marketTitle.png" width=180 >
        </v-row>
        <v-row>
            <market-reading v-if="market" :market="market"/>
            <market-comment-list @submit="onCommentSubmit" :marketComments="marketComments" />
        </v-row>
    </v-container>
</template>

<script>
import { mapActions, mapState } from 'vuex'
import axios from 'axios'
import MarketReading from '@/components/board/market/MarketReading.vue'
import MarketCommentList from '@/components/board/market/MarketCommentList.vue'

export default {
    name:'MarketReadPage',
        props: {
        boardNo: {
            type: String,
            required: true
        }
    },
    mounted() {
        this.fetchMarketCommentsList(this.boardNo)
    },
    computed: {
        ...mapState(['market' ,'marketComments'])
    },
    components: {
        MarketCommentList,
        MarketReading,

    },
    created () {
        this.fetchMarket(this.boardNo)
                .catch(() => {
                    alert('게시물 요청 실패!')
                    console.log(this.boardNo)
                    this.$router.push()
                })
    },
    
    methods: {
        ...mapActions(['fetchMarket', 'fetchMarketCommentsList']),
         onCommentSubmit (payload) {

            const { comment, commentWriter } = payload

            let formData = new FormData()

            formData.append('comment', comment)
            formData.append('commentWriter', commentWriter)
            console.log(formData)
            
            axios.post(`http://localhost:7777/board/market/${this.boardNo}/comment/register`, formData, { headers: {
                    'Content-Type': 'multipart/form-data'
                }})
                   .then(() => {
                alert('댓글이 작성되셨습니다.')
                history.go(0)
            })
            .catch (() => {
                console.log(this.boardNo)
                alert('문제 발생!')
             })
        }
        
    }

}
</script>

<style scoped>

.titleImg{
    margin-top:4%;
    margin-bottom: 6%;
}

@media (max-width:700px){
    .titleImg {
        margin-top:10%;
        margin-left:20px;
        margin-bottom:10%;
        width:200px;
    }
}

</style>
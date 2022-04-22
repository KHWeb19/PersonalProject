<template>
    <v-container >
        <v-row justify="center">
            <img class="title" src="@/assets/title/marketTitle.png" width=180 >
        </v-row>
        <v-row>
            <market-write @submit="onBoardSubmit"/>
        </v-row>
    </v-container>
</template>

<script>

import axios from 'axios'
import MarketWrite from '@/components/board/market/MarketWrite.vue'

export default {
  components: { MarketWrite },

    name: 'MarketWritePage',
    methods: {
        onBoardSubmit (payload) {
            const {formData} = payload
       
            axios.post('http://localhost:7777/board/market/register', formData, { headers: {
                    'Content-Type': 'multipart/form-data'
                }})
                    .then(() => {
                        alert('게시글이 등록되셨습니다.')

                        this.$router.push({
                            name: 'MarketPage'
                        })
                    })
                    .catch(() => {
                        alert('문제 발생!')
                    })
        }
    }
}
</script>

<style scoped>
.title{
    margin-top:4%;
    margin-bottom: 5%;
}
@media (max-width:700px){
    .title {
        margin-top:10%;
        margin-left:20px;
        margin-bottom:10%;
        width:200px;
    }
}
</style>
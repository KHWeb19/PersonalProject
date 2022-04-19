<template>
    <v-container >
        <v-row justify="center">
            <img class="title" src="@/assets/title/reviewTitle.png" width=170 >
        </v-row>
        <v-row>
            <review-write @submit="onBoardSubmit"/>
        </v-row>
    </v-container>
</template>

<script>

import axios from 'axios'
import ReviewWrite from '@/components/board/review/ReviewWrite.vue'

export default {
  components: { ReviewWrite },

    name: 'ReviewWritePage',
    methods: {
        onBoardSubmit (payload) {
            const {formData} = payload
       
            axios.post('http://localhost:7777/board/review/register', formData, { headers: {
                    'Content-Type': 'multipart/form-data'
                }})
                    .then(() => {
                        alert('게시글이 등록되셨습니다.')

                        this.$router.push({
                            name: 'ReviewPage'
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
    margin-top:5%;
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
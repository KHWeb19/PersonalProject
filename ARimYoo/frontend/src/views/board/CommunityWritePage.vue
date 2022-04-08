<template>
    <v-container class="title">
        <v-row justify="center">
            <img class="title" src="@/assets/title/communityTitle.png" width=250 >
        </v-row>
        <v-row>
            <community-board-write @submit="onSubmit"/>
        </v-row>
    </v-container>
</template>

<script>
import CommunityBoardWrite from '@/components/board/community/CommunityBoardWrite.vue'
import axios from 'axios'

export default {
  components: { CommunityBoardWrite },
    name: 'CommunityWritePage',
    methods: {
        onSubmit (payload) {
            const { title, content, writer, brackets} = payload
            axios.post('http://localhost:7777/board/community/register', { title, content, writer, brackets })
                    .then(() => {
                        alert('게시물 등록 성공!')

                        this.$router.push({
                            name: 'CommunityPage'
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
    margin-top:2.5%;
    margin-bottom: 5%;
}
</style>
<template>
    <v-container>
        <v-row justify="center">
            <img class="title" src="@/assets/title/communityTitle.png" width=250 >
        </v-row>
        <v-row>
            <community-board-read v-if="communityBoard" :communityBoard="communityBoard"/>
            <p v-else/>
        </v-row>
    </v-container>
</template>

<script>
import CommunityBoardRead from '@/components/board/community/CommunityBoardReading.vue'
import { mapActions, mapState } from 'vuex'
export default {
    name:'CommunityReadPage',
        props: {
        boardNo: {
            type: String,
            required: true
        }
    },
    computed: {
        ...mapState(['communityBoard'])
    },
    components: {
        CommunityBoardRead
    },
    created () {
        this.fetchCommunityBoard(this.boardNo)
                .catch(() => {
                    alert('게시물 요청 실패!')
                    console.log(this.boardNo)
                    this.$router.push()
                })
    },
    methods: {
        ...mapActions(['fetchCommunityBoard'])
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
        margin-top:50px;
        margin-left:20px;
        width:200px;
    }
}

</style>
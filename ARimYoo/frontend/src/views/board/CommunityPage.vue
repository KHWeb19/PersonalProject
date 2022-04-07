<template>
    <v-container class="title">
        <v-row justify="center">
            <img class="title" src="@/assets/title/communityTitle.png" width=250 >
            <v-btn @click="goPage" class="writeBtn" color="red darken-3" dark>write</v-btn>
        </v-row>
        <br/>
        <v-row justify="center">
            <community-board-list :communityBoards="communityBoards"/>
        </v-row>
    </v-container>
</template>

<script>
import CommunityBoardList from '@/components/board/community/CommunityBoardList.vue'
import { mapState, mapActions } from 'vuex'
export default {
  components: { CommunityBoardList },
    name:'CommunityPage',
    computed: {
        ...mapState(['communityBoards'])
    },
    mounted () {
        this.fetchCommunityBoardList()
    },
    methods: {
        ...mapActions(['fetchCommunityBoardList']),
        goPage(){
            this.$router.push('/community/write')
        }
    }
}
</script>

<style scoped>
.title{
    margin-top:2.5%;
    margin-bottom: 5%;
}
.writeBtn {
    position: absolute;
    left:78%;
    top:30%;
    zoom:1.15;
}
</style>

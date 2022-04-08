<template>
    <v-container id="item">
        <v-row justify="center">
            <img class="titleImg" src="@/assets/title/communityTitle.png" width=250 >
            <v-btn @click="goPage" class="writeBtn" color="red darken-3" dark fab><v-icon color="white"> mdi-pencil </v-icon></v-btn>
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
.titleImg{
    margin-top:5%;
    margin-bottom: 6%;
}
.writeBtn {
    position: absolute;
    left:78%;
    top:9%;
    zoom:1.15;
}
@media (max-width:700px){
    .writeBtn {
        zoom:80%;
        top:3%;
        margin-left:15px;
    }
    .titleImg {
        margin-top:10%;
        margin-left:20px;
        margin-bottom:10%;
        width:200px;
    }
}
</style>

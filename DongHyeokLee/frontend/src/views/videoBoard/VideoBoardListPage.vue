<template>
    <div id="photoBoard">
        <h2>영상게시판</h2>
        <div>
        <video-board-list :videoBoards="videoBoards"/>
        </div>
       
        <router-link :to="{ name: 'VideoBoardRegisterPage'}">
            <v-btn v-if="$store.state.isLogin == true" class="blue" dark>
                <v-icon>mdi-pencil-plus</v-icon>
                <span>등록</span>
            </v-btn>
        </router-link>
    </div>
</template>

<script>


import { mapActions, mapState } from 'vuex'
import VideoBoardList from '@/components/videoBoard/VideoBoardList.vue'



export default {
    name: 'VideoBoardListPage',
    components: {
        VideoBoardList
        
    },
    computed: {
        ...mapState(['videoBoards'])
        
    },
    mounted () {
        this.fetchVideoBoardList()
        
    },
    methods: {
        ...mapActions(['fetchVideoBoardList'])
       
    }

}
</script>

<style scoped>

h2 {
    text-align: center;
    padding: 15px;
}

a {
    text-decoration: none;
    margin-left: 1230px;

}

    
</style>
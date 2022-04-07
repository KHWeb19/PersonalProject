<template>
    <div id="photoBoard">
        <h2>사진게시판</h2>
        <div>
        <photo-board-list :photoBoards="photoBoards"/>
        </div>
       
        <router-link :to="{ name: 'PhotoBoardRegisterPage'}">
            <v-btn v-if="$store.state.isLogin == true" class="blue" dark>
                <v-icon>mdi-pencil-plus</v-icon>
                <span>등록</span>
            </v-btn>
        </router-link>
    </div>
</template>

<script>


import { mapActions, mapState } from 'vuex'
import PhotoBoardList from '@/components/photoBoard/PhotoBoardList.vue'



export default {
    name: 'PhotoBoardListPage',
    components: {
        PhotoBoardList,
        
    },
    computed: {
        ...mapState(['photoBoards'])
        
    },
    mounted () {
        this.fetchPhotoBoardList()
        
    },
    methods: {
        ...mapActions(['fetchPhotoBoardList'])
       
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
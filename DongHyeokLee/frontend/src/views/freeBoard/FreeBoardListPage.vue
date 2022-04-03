<template>
    <div id="freeBoard">
        <h2>자유게시판</h2>
        <free-board-list :freeBoards="freeBoards"/>
       
        <router-link :to="{ name: 'FreeBoardRegisterPage'}">
        
        <v-btn class="blue" dark>
            <v-icon>mdi-pencil-plus</v-icon>
            <span>등록</span>
        </v-btn>
        </router-link>
    </div>
</template>

<script>


import { mapActions, mapState } from 'vuex'
import FreeBoardList from '@/components/freeBoard/FreeBoardList.vue'



export default {
    name: 'FreeBoardListPage',
    components: {
        FreeBoardList,
        
    },
    computed: {
        ...mapState(['freeBoards'])
        
    },
    mounted () {
        this.fetchFreeBoardList()
        
    },
    methods: {
        ...mapActions(['fetchFreeBoardList'])
       
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
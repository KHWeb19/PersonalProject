<template>
<div id="tipboard">
<div v-if="this.$store.state.userInfo == null">

<h1>회원만 이용 가능한 게시판 입니다.</h1>

</div>

<br>

<div v-if="this.$store.state.userInfo != null">
   <v-row>
         <v-text-field v-model="search" label="Search" append-icon="mdi-magnify" 
      solo hide-details></v-text-field>
      
      <v-btn @click="register">
      <v-icon>add</v-icon>
      </v-btn>
   </v-row>

<v-container justify-center space-between>
   <tip-board-list :tipBoards="tipBoards"/>
</v-container>

</div>

<br>



</div>
</template>

<script>
import TipBoardList from '@/components/livingTip/TipBoardList.vue'
import { mapState, mapActions } from 'vuex'

export default {
   name: 'LivingTipBoardList',
   components: {
      TipBoardList
   },
    computed: {
        ...mapState(['tipBoards'])
    },
    mounted () {
        this.fetchTipBoardList()
    },
    methods: {
        ...mapActions(['fetchTipBoardList']),
        register() {
           this.$router.push({ name:'tipRegisterPage' })
        },
        search(){
           
        }
    }
}
</script>

<style scoped>
#search {
   width: 800px;
}
</style>
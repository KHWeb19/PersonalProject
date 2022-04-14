<template>
<div id="tipboard">
   <v-toolbar class="my-3 pt-3" color="primary" flat>
      <v-text-field v-model="search" label="Search" append-icon="mdi-magnify" 
      solo hide-details></v-text-field>
      
      <v-btn @click="register">
      <v-icon>add</v-icon>
      </v-btn>
   </v-toolbar>

<v-container justify-center space-between>
   <tip-board-list :tipBoards="tipBoards"/>
</v-container>

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
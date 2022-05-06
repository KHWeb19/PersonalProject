<template>
<div>
  <v-container>
        <header-view></header-view>
        <br>
     <div align="center">
        <sold-board-read :ProductBoardB="ProductBoardB" :boardNo=" boardNo"/>
        
            <br>

            <router-link style="text-decoration: none; color:black"
            :to="{ name: 'K2SoldView' }">
                <v-btn text color="black" rounded x-large
                        style="padding: 10px; width: 90px;">
                목록으로
                </v-btn>
            </router-link>
        </div>
    
    </v-container>   
    <footer-view/>
</div>
</template>
<script>
import { mapState, mapActions } from 'vuex'
import HeaderView from '@/components/home/headerView.vue'
import SoldBoardRead from '@/components/SoldProductBoard/SoldBoardRead.vue'
import FooterView from '@/components/home/footerView.vue'
//import ReadQuestionComment from '@/components/comment/ReadQuestionComment'

export default {
    name:'K2SoldReadPage',
    components:{ 
    HeaderView,
    SoldBoardRead,
        FooterView,
    //ReadQuestionComment,
    },
    props: {
        boardNo: {
            type: String,
            required: true
        }   
    },
    computed: {
        ...mapState(['ProductBoardB','userInfo'])
    },
    created () {
            this.fetchProductBoardb(this.boardNo)
                .catch(err => {
                    alert(err.response.data.message)
                    this.$router.push()
                })
    },
     methods: {
        ...mapActions(['fetchProductBoardb'])},
}
</script>
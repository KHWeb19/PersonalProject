<template>
  <v-container>
        <header-view></header-view>
        <br>
     <div align="center">
        <basket-read :ProductBoardB="ProductBoardB" :boardNo=" boardNo"/>
        
            <br>

           
                <v-btn text color="black" rounded x-large
                       style="padding: 10px; width: 90px;">
                장바구니에서 삭제
                </v-btn>
        </div>
    
    </v-container>   
</template>
<script>
import { mapState, mapActions } from 'vuex'
import HeaderView from '@/components/home/headerView.vue'
import BasketRead from '@/components/BasketBoard/BasketRead.vue'

export default {
    name:'K3basketReadPage',
    components:{ 
    HeaderView,
    SoldBoardRead,
    BasketRead,
    },
    props: {
        boardNo: {
            type: String,
            required: true
        }   
    },
    computed: {
        ...mapState(['BasketBoard','userInfo'])
    },
    created () {
            this.fetchBasketBoard(this.boardNo)
                .catch(err => {
                    alert(err.response.data.message)
                    this.$router.push()
                })
    },
     methods: {
        ...mapActions(['fetchBasketBoard'])},
}
</script>
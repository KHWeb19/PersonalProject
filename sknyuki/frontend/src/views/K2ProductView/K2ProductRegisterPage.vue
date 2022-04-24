<template>
<div>
      <header-view></header-view>
      <product-board-register></product-board-register>
   
</div>
</template>

<script>
import HeaderView from '@/components/home/headerView.vue'
import ProductBoardRegister from '@/components/ProductBoard/ProductBoardRegister.vue'
export default {
    name:'K2ProductRegisterPage',
    components:{ 
    HeaderView,
    ProductBoardRegister,
       
        
    }
}
</script>
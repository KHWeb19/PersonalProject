<template>
<div align="center" >
   <br> <br>
   <h1> 기부 정보 확인 </h1>
   <br>
   <v-container style="width: 1200px">
      <v-row justify="center">
         <cloth-info/>
         <towel-info/>
         <book-info/>
         <bag-info/>
         <suit-info/>
         <appliance-info/>
      </v-row>
   </v-container>
</div>
</template>

<script>
import ClothInfo from '@/components/donation/ClothInfo.vue'
import TowelInfo from '@/components/donation/TowelInfo.vue'
import BookInfo from '@/components/donation/BookInfo.vue'
import BagInfo from '@/components/donation/BagInfo.vue'
import SuitInfo from '@/components/donation/SuitInfo.vue'
import ApplianceInfo from '@/components/donation/ApplianceInfo.vue'

export default {
    name: 'donationInfoPage',
    components: {
       ClothInfo,
       TowelInfo,
       BookInfo,
       BagInfo,
       SuitInfo,
       ApplianceInfo
    }
}
</script>

<style scoped>
h1{
  color: #907bb0;
}
</style>
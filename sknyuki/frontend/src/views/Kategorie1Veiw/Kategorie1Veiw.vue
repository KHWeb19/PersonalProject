<template>
    <v-container>
        <header-view></header-view>
        <br>
        <drop-down></drop-down>


    </v-container>
</template>
<script>
import HeaderView from '@/components/home/headerView.vue'
import DropDown from '@/components/KategoriePage1/DropDown.vue'
export default {
    name:'Kategorie1View',
    components:{ 
    HeaderView,
    DropDown,
        
    }

}

</script>
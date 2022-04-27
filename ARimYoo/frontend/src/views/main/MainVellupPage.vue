<template>
    <div>
            <main-vellup/>
    </div>
</template>



<script>
import MainVellup from '@/components/MainVellup.vue'

export default {
    name: 'MainVellupPage',
    components: {
        MainVellup

    },


}
</script>

<style scoped>
.mx-auto {
    margin-top: 10px;
    width:70%;
}
.deco {
    position:absolute; 
    top:35%; left:17%; width:35%;
}
</style>
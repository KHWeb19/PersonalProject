<template>
    <div>
        <br>
        <v-container >
        <h1>우리동네 수거함 위치</h1>

        <guide-box-form/>
        </v-container>
    </div>
</template>

<script>
import GuideBoxForm from '@/components/recycleGuide/GuideBoxForm.vue'

export default {
    name: 'guideBoxPage',
    components: { GuideBoxForm },

    
}
</script>

<style scoped>

</style>
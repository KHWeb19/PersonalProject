<template>
    <div>
        <br>
        <v-container>
            <guide-search-form/>
        </v-container>
    </div>
</template>

<script>
import GuideSearchForm from '@/components/recycleGuide/GuideSearchForm.vue'

export default {
    name: 'guideBoxPage',
    components: { GuideSearchForm },    
}
</script>

<style scoped>

</style>
<template>
    <div>
        <br>
        <v-container style="width: 53%;">
            <v-btn id="btn2" @click="goMain">돌아가기</v-btn>

            <guide-search-form/>
        </v-container>
    </div>
</template>

<script>
import GuideSearchForm from '@/components/recycleGuide/GuideSearchForm.vue'

export default {
    name: 'guideBoxPage',
    components: { GuideSearchForm },
    methods: {
        goMain(){
            this.$router.push({ name: 'recycleGuideMainPage' })
        },
    }  
}
</script>

<style scoped>
#btn2{
    color: white;
    background-color: darkkhaki;
    width: 120px;
    box-shadow: none;  
}
</style>
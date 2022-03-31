<template>
    <div class="Main">
        <main-page-form></main-page-form>

        <div class="findIdPw" align="center">
            <find-id-pw-form></find-id-pw-form>
        </div>

        <footer-form></footer-form>
    </div>
</template>

<script>
import FooterForm from '@/components/layout/FooterForm.vue'
import MainPageForm from '@/components/layout/MainPageForm.vue'
import FindIdPwForm from '@/components/mainPage/FindIdPwForm.vue'
    export default {
        name: 'FindIdPw',
        components: { 
            MainPageForm,
            FooterForm,
            FindIdPwForm
        },

    }
</script>

<style scoped>
.Main {
    background: rgb(255, 186, 186);
    background-size : cover;
}
.findIdPw {
    margin:2% 10% 3% 10%;
    padding: 15px;
    border: 3px ;
}
</style>
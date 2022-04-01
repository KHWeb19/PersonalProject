<template>
    <div class="Main">
        <main-page-form></main-page-form>

        <div class="cakeImg">
            <preview-cake-form></preview-cake-form>
        </div>
    </div>
</template>

<script>
import PreviewCakeForm from '@/components/mainPage/PreviewCakeForm.vue'
import MainPageForm from '@/components/layout/MainPageForm.vue'

    export default {
        name: 'PreviewCakeImg',
        components: {
            PreviewCakeForm,
            MainPageForm
        }

    }
</script>

<style scoped>

.Main {
    background: rgb(255, 186, 186);
}
.MainLogo {
    display: block; margin: 0px auto;
}

.cakeImg {
    margin:2% 10% 3% 10%;
    padding: 15px;
    border: 3px solid rgb(243, 180, 180);
}

a {
    text-decoration: none;
    font: 300;
}

p {
    color: rgb(0, 0, 0);
    font-weight: 600;
}
hr{ 
    background: #e69191;
    height: 3px;
}
</style>
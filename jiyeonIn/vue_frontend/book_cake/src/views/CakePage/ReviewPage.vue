<template>
    <div class="Main">
        <main-page-form></main-page-form>
    </div>
</template>

<script>
import MainPageForm from '@/components/mainPage/MainPageForm.vue'

    export default {
        name: 'ReviewPage',
        components: {
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
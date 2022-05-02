<template>
<div align="center">
   <br> <br>
   <h1> 메일로 제보하기 </h1>
   <email-form/>
</div>
</template>

<script>
import emailForm from '@/components/emailForm.vue'

export default {
   name: 'emailReportPage',
   components: { emailForm },    
}
</script>

<style scoped>
h1{
  color: #907bb0;
}
</style>
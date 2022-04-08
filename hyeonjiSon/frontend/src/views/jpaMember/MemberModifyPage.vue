<template>
<div>
   <h1> Modify Page </h1>
   
   <modify-form/>
</div>
</template>

<script>
import ModifyForm from '@/components/jpaMember/ModifyForm.vue'

export default {
    name: "MemberModifyPage" ,
    components: {
       ModifyForm
    }
}
</script>
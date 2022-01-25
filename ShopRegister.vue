<template>
  <div class="register-shop-container">
    <div class="form-container">
      <a-form-model
        :model="form"
        ref="shopForm"
        :rules="rules"
        v-bind="formLayout"
      >

        <a-form-model-item label="Name" prop="name">
          <a-input v-model="form.name" />
        </a-form-model-item>
        <a-form-model-item label="Phone" prop="phone">
          <a-input v-model="form.phone" />
        </a-form-model-item>
        <a-form-model-item label="Address" prop="address">
          <a-input v-model="form.address" />
        </a-form-model-item>
        <a-form-model-item label="Cert" prop="business_cert">
          <a-input v-model="form.business_cert" />
        </a-form-model-item>
      </a-form-model>
    </div>

    <!-- <div class="submit"><button class="full-width">Submit</button></div> -->
    <div class="submit">
      <div class="edit-shop" v-if="isEditPage">
        <a-button type="default" @click="cancelEditForm">
          Cancel
        </a-button>
        <a-button type="primary" @click="submitForm">
          Save
        </a-button>
      </div>
      <div class="create-shop" v-else>
        <a-button type="primary" :block="true" @click="submitForm">
          Register to become shop
        </a-button>
      </div>
    </div>
  </div>
</template>
<script>
import uploadService from "../api-services/uploadService.js";
import { mapMutations } from "vuex";
import { cloneDeep } from "loadsh";
import shopService from "../api-services/shopService.js";
export default {
  name: "Registershop",
  data: () => ({
    defaultForm: {
      id: "",
      name: "",
      phone: "",
      address: "",
      business_cert: ""
    },
    form: {},
    originForm: {},
    formLayout: {
      labelCol: { span: 4 },
      wrapperCol: { span: 24 },
      labelAlign: "left"
    },
    type: "",
    rules: {
      name: [
        { required: true, message: "This field is required", trigger: "blur" }
      ],
      phone: [
        { required: true, message: "This field is required", trigger: "blur" }
      ],
      address: [
        { required: true, message: "This field is required", trigger: "blur" }
      ],
      business_cert: [
        { required: true, message: "This field is required", trigger: "blur" }
      ],

    },
    isEditPage: false,
    shopId: null,
    isUploadImage: false
  }),
  computed: {
    defaultAvatar() {
      return require("../assets/avatar-default.svg");
    },
    getAvatar() {
      if (!this.form.avatar) {
        return this.defaultAvatar;
      }
      return this.form.avatar;
    },
    getNegativeCert() {
      if (!this.form.negative_cert) {
        return "";
      }
      return this.form.negative_cert;
    },
    getVaccineCert() {
      if (!this.form.vaccine_cert) {
        return "";
      }
      return this.form.vaccine_cert;
    }
  },
  methods: {
    handleBlur() {},

    handleChangeImage(type) {
      switch (type) {
        case "avatar":
          this.type = "avatar";
          this.$refs.inputImage.value = null;
          this.$refs.inputImage.click();
          break;
        case "negative":
          this.type = "negative";
          this.$refs.inputNegativeCert.value = null;
          this.$refs.inputNegativeCert.click();
          break;
        case "vaccine":
          this.type = "vaccine";
          this.$refs.inputVaccineCert.value = null;
          this.$refs.inputVaccineCert.click();
          break;
        default:
          this.type = "avatar";
          break;
      }
    },
    async handleChangeFile(event) {
      if (event.target.files.length === 0) {
        return;
      }
      this.isUploadImage = true;
      const formData = new FormData();
      formData.append("file", event.target.files[0]);
      const rs = await uploadService.uploadToServer(formData);
      if (!rs || !rs.success) {
        this.isUploadImage = false;

        return;
      }
      switch (this.type) {
        case "avatar":
          this.form.avatar = rs.data.path;
          break;
        case "negative":
          this.form.negative_cert = rs.data.path;
          break;
        case "vaccine":
          this.form.vaccine_cert = rs.data.path;
          break;
        default:
          break;
      }
      this.isUploadImage = false;
    },
    submitForm() {
      this.$refs["shopForm"].validate(async valid => {
        if (!valid) {
          return;
        }
        this.setLoading(true);
        const payload = cloneDeep(this.form);
        delete payload.id;
        try {
          let rs;
          if (this.isEditPage) {
            rs = await shopService.update(this.shopId, payload);
          } else {
            rs = await shopService.create(payload);
          }
          this.setLoading(false);
          let type = "success";
          let msg = "Register successfully";
          if (!rs) {
            type = "error";
            msg = "Register failed";
          }
          this.$message[type](msg, 3);
          this.$router.push({ name: "/" });
        } catch (error) {
          this.setLoading(false);
        }
      });
    },
    ...mapMutations("shop", ["setLoading"]),
    async initData() {

      this.setLoading(true);
      let type = "error";
      let msg = "Load data fail";
      this.shopId = this.$route.params.id;
      if (!this.shopId) {
        this.$message[type](msg, 3);
        this.setLoading(false);

        return;
      }

      const rs = await shopService.getDetail(this.shopId);
      if (!rs) {
        this.$message[type](msg, 3);
        this.setLoading(false);

        return;
      }

      this.originForm = cloneDeep(rs);
      this.form = cloneDeep(rs);
      this.setLoading(false);
    },
    cancelEditForm() {
      this.form = cloneDeep(this.originForm);
    }
  },
  async mounted() {
    this.form = cloneDeep(this.defaultForm);
    if (this.$route.name !== "ProductName") {
      return;
    }
    this.isEditPage = true;
    await this.initData();
  }
};
</script>
<style scoped>
.register-shop-container {
  display: flex;
  flex-direction: column;

  margin: 40px;
}
.form-input {
  display: flex;
  flex-direction: column;

  margin: 16px 0;
}

.avatar {
  flex-grow: 1;

  display: flex;
  flex-direction: column;
  align-items: center;
}

.form {
  flex-grow: 4;
}

.button-upload {
  max-width: 160px;
}
.full-width {
  width: 100%;
  height: 40px;
}
</style>

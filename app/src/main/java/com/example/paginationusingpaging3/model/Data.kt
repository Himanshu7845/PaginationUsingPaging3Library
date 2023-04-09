package com.example.paginationusingpaging3.model

data class Data(
    val categoryId: String,
    val category_ofproduct: CategoryOfproduct,
    val createdAt: String,
    val description: String,
    val descriptionHindi: String,
    val priority: Int,
    val productId: String,
    val productImages_ofproduct: List<ProductImagesOfproduct>,
    val productName: String,
    val productNameHindi: String,
    val updatedAt: String,
    val variant_ofproduct: List<VariantOfproduct>,
    val warehouseId: String
)
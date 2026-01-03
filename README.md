# 🍱 外卖订单统计与管理系统

一个基于 SSM 框架的外卖订单管理与统计系统，支持商家后台管理与用户在线点餐。

---

## 📌 项目简介

本项目是一个完整的外卖订单管理系统，采用 **SSM（Spring + SpringMVC + MyBatis）** 框架开发，实现了商家端订单管理、菜品管理、订单统计与用户端在线点餐、退单等功能。系统设计遵循分层架构，具备较好的扩展性与维护性。

---

## 🛠 技术栈

- **后端框架**：Spring + SpringMVC + MyBatis
- **数据库**：MySQL 8.0
- **前端技术**：JSP + JavaScript + HTML + CSS
- **项目管理工具**：Maven
- **服务器**：Tomcat 8.5
- **开发工具**：Eclipse / IDEA

---

## 📂 功能模块

### 🏪 商家端功能
- 登录注册与权限控制
- 菜品管理（增删改查、上下架）
- 订单管理（接单、拒收、查看详情）
- 订单统计（按日期、菜品多维度统计）
- 会员管理（会员信息查询、积分管理）

### 🧑‍💼 用户端功能
- 用户注册与登录
- 菜品浏览与点餐
- 购物车管理（添加、修改、删除）
- 订单提交与退单
- 会员积分与折扣优惠

---

## 🗄️ 数据库设计

系统共设计7张核心表：
- `user`（用户表）
- `menu`（菜品表）
- `category`（菜品类别表）
- `member`（会员表）
- `discount`（折扣表）
- `order_header`（订单头表）
- `order_detail`（订单详情表）

通过外键关联、触发器、视图等技术保障数据一致性与查询效率。

---

## 🚀 运行说明

### 环境要求
- JDK 8+
- MySQL 8.0+
- Tomcat 8.5+
- Maven 3.6+

### 部署步骤
1. 克隆项目到本地：
   ```bash
    git clone https://github.com/undefined-sign/Food_Delivery_Order_System.git
   ```
   
2. **导入数据库脚本**
   - 执行 `sql/` 目录下的数据库脚本，创建系统所需的数据表、视图和触发器。

3. **配置数据库连接**
   - 修改 `src/main/resources/jdbc.properties` 文件，配置你的 MySQL 数据库连接信息。

4. **使用 Maven 构建项目**
   ```bash
   mvn clean package
   ```

5. **部署与运行**
   - 将生成的 WAR 包部署至 Tomcat 服务器。
   - 或直接在 IDE（如 Eclipse/IDEA）中配置 Tomcat 并运行项目。
